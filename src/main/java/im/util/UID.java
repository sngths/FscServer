package im.util;

import org.springframework.cache.Cache;

import java.io.UnsupportedEncodingException;

/**
 * Created by tianxing on 16/12/7.
 * 用户ID
 */
public class UID {


    private final String username;
    private final String domain;
    private final String resource;




    public UID(String uid) {
        this(getParts(uid));
    }


    private UID(String[] parts) {
        this(parts[0], parts[1], parts[2]);
    }


    public UID(String username, String domain, String resource) {
        if(domain == null) {
            throw new NullPointerException("Domain cannot be null");
        } else {
                this.username = username;
                this.domain = domain;
                this.resource = resource;
        }
    }




    static String[] getParts(String uid){
        if(uid == null) {
            throw new IllegalArgumentException("Argument cannot be null.");
        } else {
            int slashIndex = uid.indexOf("/");
            int atIndex = uid.indexOf("@");
            if(slashIndex > -1 && atIndex > slashIndex) {
                atIndex = -1;
            }

            if(atIndex == 0) {
                throw new IllegalArgumentException("Existing at-character at the first character of the string indicates that an empty node part is provided. This is illegal.");
            } else if(slashIndex == uid.length() - 1) {
                throw new IllegalArgumentException("Existing slash at the very end of the string indicates that an empty resource part is provided. This is illegal.");
            } else {
                String node = null;
                if(atIndex > 0) {
                    node = uid.substring(0, atIndex);
                }

                String domain = null;
                if(atIndex + 1 > uid.length()) {
                    throw new IllegalArgumentException("JID with empty domain not valid");
                } else {
                    if(atIndex < 0) {
                        if(slashIndex > 0) {
                            domain = uid.substring(0, slashIndex);
                        } else {
                            domain = uid;
                        }
                    } else if(slashIndex > 0) {
                        domain = uid.substring(atIndex + 1, slashIndex);
                    } else {
                        domain = uid.substring(atIndex + 1);
                    }

                    String resource = null;
                    if(slashIndex + 1 <= uid.length() && slashIndex >= 0) {
                        resource = uid.substring(slashIndex + 1);
                    } else {
                        resource = null;
                    }

                    String[] parts = new String[]{node, domain, resource};
                    return parts;
                }
            }
        }
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(this.username != null) {
            sb.append(this.username);
            sb.append('@');
        }

        sb.append(this.domain);
        if(this.resource != null) {
            sb.append('/');
            sb.append(this.resource);
        }

        return sb.toString();
    }

    public String getUsername() {
        return username;
    }

    public String getDomain() {
        return domain;
    }

    public String getResource() {
        return resource;
    }

    @Override
    public boolean equals(Object object) {
        if(!(object instanceof UID)) {
            return false;
        } else if(this == object) {
            return true;
        } else {
            UID jid = (UID)object;
            if(this.username != null) {
                if(!this.username.equals(jid.username)) {
                    return false;
                }
            } else if(jid.username != null) {
                return false;
            }

            if(!this.domain.equals(jid.domain)) {
                return false;
            } else {
                if(this.resource != null) {
                    if(!this.resource.equals(jid.resource)) {
                        return false;
                    }
                } else if(jid.resource != null) {
                    return false;
                }

                return true;
            }
        }
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
}
