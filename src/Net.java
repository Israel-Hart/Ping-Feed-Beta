import java.net.Inet4Address;
import java.net.InetAddress; 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

class Net{   
    
    private String host; 
    private final String REGEX_URL = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$"; 
    private final String REGEX_IP = "^(([a-zA-Z0-9]|[a-zA-Z0-9][a-zA-Z0-9\\-]*[a-zA-Z0-9])\\.)*([A-Za-z0-9]|[A-Za-z0-9][A-Za-z0-9\\-]*[A-Za-z0-9])$";
    Net() {
        
    }

    boolean ping(String addr, int duration)
     { //addr = address
        
        try{ 
            InetAddress address = InetAddress.getByName(addr);
            host = address.getHostName();
            return address.isReachable(duration); 
        }catch(Exception e )
        {
            e.printStackTrace(); 
        }

        return false;
    }

    String getHost() { /* return host name */
        String res = host == null ? null : host;
        return res;  
    }

    boolean validateAddress(String addr){
        try { 
            Pattern url_pattern = Pattern.compile(REGEX_URL); 
            Pattern ip_pattern = Pattern.compile(REGEX_IP); 
            Matcher url_matcher = url_pattern.matcher(addr);
            Matcher ip_matcher = ip_pattern.matcher(addr);

            if(url_matcher.find() || ip_matcher.find()) 
            {
                return true;
            }

        }catch(PatternSyntaxException pe)
        {
            pe.printStackTrace();
        }
        return false; 
    }
}