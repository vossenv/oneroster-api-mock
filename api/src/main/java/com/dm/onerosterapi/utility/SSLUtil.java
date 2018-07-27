package com.dm.onerosterapi.utility;

import org.springframework.stereotype.Component;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

@Component
public class SSLUtil {

    private HostnameVerifier defaultVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
    private HostnameVerifier bypassVerifier = (hostname, sslSession) -> true;

    public void disableSSLCheck() {
        HttpsURLConnection.setDefaultHostnameVerifier(this.bypassVerifier);
    }

    public void enableSSLCheck(){
        HttpsURLConnection.setDefaultHostnameVerifier(this.defaultVerifier);
    }

}
