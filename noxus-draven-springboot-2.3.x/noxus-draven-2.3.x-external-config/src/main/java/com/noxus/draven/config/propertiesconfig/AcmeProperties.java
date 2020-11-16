package com.noxus.draven.config.propertiesconfig;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author draven
 */
@Component
@ConfigurationProperties("acme")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Valid
public class AcmeProperties {
    private boolean enabled;
    @NotNull
    private InetAddress remoteAddress;
    private final Security security = new Security();

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public InetAddress getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(InetAddress remoteAddress) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        /*byte[] address = localHost.getAddress();
        String ip = address.toString();*/

        if (null == remoteAddress) {
            this.remoteAddress = localHost;
        } else {
            this.remoteAddress = remoteAddress;
        }
    }

    public Security getSecurity() {
        return security;
    }

   /*public boolean isEnabled() { }

    public void setEnabled(boolean enabled) { }

    public InetAddress getRemoteAddress() { }

    public void setRemoteAddress(InetAddress remoteAddress) { ...}

    public Security getSecurity() { }*/

    public static class Security {
        private String username;
        private String password;
        private List<String> roles = new ArrayList<>(Collections.singleton("USER"));

        /*public String getUsername() { }

        public void setUsername(String username) { ...}

        public String getPassword() { ...}

        public void setPassword(String password) { ...}

        public List<String> getRoles() { ...}

        public void setRoles(List<String> roles) { ...}*/
    }
}
