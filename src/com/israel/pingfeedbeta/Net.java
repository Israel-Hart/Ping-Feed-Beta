// handle pinging and input validation 

import java.io.IOException;
import java.net.InetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.net.UnknownHostException;



class Net{   

    private String host; 
    //Regular Expression for IP Address 
    private final String REGEX_IP = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";
    //updated to support hostnames 
    private final String REGEX_COMPUTER_NAME = "^(?![0-9]{1,15}$)[a-zA-Z0-9-]{1,15}$";

    boolean ping(String addr, int duration)
     { //addr = address
        try{ 
            InetAddress address = InetAddress.getByName(addr);
            host = address.getHostName();
            return address.isReachable(duration); 
        }catch(UnknownHostException uh)
        {
            System.out.println("The host was not found on the network.");
        }catch(IOException io)
        {
            System.out.println("An io exception occured!");
        }
        return false;
    }

    String getHost() { /* return host name */
        String res = host == null ? null : host;
        return res;  
    }

    boolean validateAddress(String addr) {
        try { 
            Pattern hostname_pattern = Pattern.compile(REGEX_COMPUTER_NAME); //pattern for hostnames 
            Pattern ip_pattern = Pattern.compile(REGEX_IP);
            Matcher hostname_matcher = hostname_pattern.matcher(addr); //regex matcher for hostnames
            Matcher ip_matcher = ip_pattern.matcher(addr); 

            if(hostname_matcher.find() || ip_matcher.find()) { //added hostname condition
                return true;
            }
        }catch(PatternSyntaxException pe )
        {
            System.out.println("Syntax not found!");
        }
        return false; 
    }
}