package Sneha.com.Networks;

import java.util.*;

public class DHCPServerSimulation {
      
      private static final Random random = new Random();
      
      // Function to generate random MAC Address
      public static String generateMac() {
            StringBuilder mac = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                  int octet = random.nextInt(256);
                  mac.append(String.format("%02x", octet));
                  if (i != 5) {
                        mac.append(":");
                  }
            }
            return mac.toString();
      }
      
      // Function to generate random IP address within a given base
      public static String generateIp(String baseIp, Set<String> usedIps) {
            String[] parts = baseIp.split("\\.");
            while (true) {
                  int lastOctet = 2 + random.nextInt(253); // Avoid 0, 1, 255
                  String newIp = parts[0] + "." + parts[1] + "." + parts[2] + "." + lastOctet;
                  if (!usedIps.contains(newIp)) {
                        return newIp;
                  }
            }
      }
      
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            
            System.out.print("Enter base network (example 192.168.1.0): ");
            String baseNetwork = sc.nextLine();
            
            System.out.print("Enter network CIDR (example 24): ");
            String cidr = sc.nextLine();
            
            System.out.print("Enter total number of hosts to accommodate: ");
            int totalHosts = sc.nextInt();
            
            System.out.print("Enter number of initially allocated hosts: ");
            int initiallyAllocated = sc.nextInt();
            
            // IP pool and used IP tracking
            Set<String> poolIps = new HashSet<>();
            Set<String> usedIps = new HashSet<>();
            
            // Generate IP pool
            while (poolIps.size() < totalHosts) {
                  String ip = generateIp(baseNetwork, usedIps);
                  poolIps.add(ip);
            }
            
            // DHCP table: MAC -> IP
            Map<String, String> dhcpTable = new HashMap<>();
            
            // Allocate initially assigned hosts
            for (int i = 0; i < initiallyAllocated; i++) {
                  String mac = generateMac();
                  String ip = poolIps.iterator().next();
                  poolIps.remove(ip);
                  dhcpTable.put(mac, ip + "/" + cidr);
                  usedIps.add(ip);
            }
            
            // Allocate new hosts
            int newHosts = totalHosts - initiallyAllocated;
            for (int i = 0; i < newHosts; i++) {
                  String mac = generateMac();
                  String ip = poolIps.iterator().next();
                  poolIps.remove(ip);
                  dhcpTable.put(mac, ip + "/" + cidr);
                  usedIps.add(ip);
            }
            
            // Print the DHCP Server Allocation Table
            System.out.println("\nDHCP Server Allocation Table:");
            for (Map.Entry<String, String> entry : dhcpTable.entrySet()) {
                  System.out.println(entry.getKey() + " | " + entry.getValue());
            }
            
            sc.close();
      }
}
