package btc;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Random;

public class Client {

    public static final String username = "lum-customer-hl_19578df9-zone-static";
    public static final String password = "pechbuc8qmm6";
    public static final int port = 22225;
    public static final String user_agent =
            "Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0";
    public String session_id = Integer.toString(new Random().nextInt(Integer.MAX_VALUE));
    public CloseableHttpClient client;

    public Client(String country) {
        String login = username+(country!=null ? "-country-"+country : "")
                +"-session-" + session_id;
        HttpHost super_proxy = new HttpHost("zproxy.lum-superproxy.io", port);
        CredentialsProvider cred_provider = new BasicCredentialsProvider();
        cred_provider.setCredentials(new AuthScope(super_proxy),
                new UsernamePasswordCredentials(login, password));
        client = HttpClients.custom()
                .setConnectionManager(new BasicHttpClientConnectionManager())
                .setProxy(super_proxy)
                .setDefaultCredentialsProvider(cred_provider)
                .build();
    }

    public String request(String url) throws IOException {
        HttpGet request = new HttpGet(url);
        request.setHeader("User-Agent", user_agent);
        CloseableHttpResponse response = client.execute(request);
        try {
            return EntityUtils.toString(response.getEntity());
        } finally { response.close(); }
    }

    public void close() throws IOException { client.close(); }
}

