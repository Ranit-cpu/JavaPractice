package Sneha.com.Networks;

import java.util.Scanner;

public class NetworkSimulation {
      
      // Convert an integer to dotted decimal IP format
      public static String intToIp(int ip) {
            return ((ip >> 24) & 255) + "." + ((ip >> 16) & 255) + "." + ((ip >> 8) & 255) + (ip & 255);
      }
      
      // Calculate the number of bits needed for the subnet mask
      public static int calculateSubnetBits(int hosts) {
            return (int) Math.ceil(Math.log(hosts + 2) / Math.log(2)); // +2 for network and broadcast
      }
      
      // Calculate the subnet mask
      public static String calculateSubnetMask(int bits) {
            int mask = (0xFFFFFFFF << (32 - bits));
            return intToIp(mask);
      }
      
      // Calculate the network address
      public static String calculateNetworkAddress(int ip, int mask) {
            int network = ip & mask;
            return intToIp(network);
      }
      
      // Calculate the first and last IP in the network
      public static String[] calculateFirstLastIP(int network, int hosts) {
            int first = network + 1;
            int last = network + hosts - 2;
            return new String[]{intToIp(first), intToIp(last)};
      }
      
      // Generate all IP addresses in the network
      public static String[] generateAllIPs(int network, int hosts) {
            String[] ips = new String[hosts];
            for (int i = 0; i < hosts; i++) {
                  int ip = network + i;
                  ips[i] = intToIp(ip);
            }
            return ips;
      }
      
      // Handle subnetting
      public static String[][] subnetting(int network, int subnetMask, int subnets, int hosts) {
            String[][] subnetsIPs = new String[subnets][hosts];
            int subnetMaskBits = calculateSubnetBits(hosts);
            for (int i = 0; i < subnets; i++) {
                  int subnetNetwork = network + i * (1 << (32 - subnetMaskBits));
                  subnetsIPs[i] = generateAllIPs(subnetNetwork, hosts);
            }
            return subnetsIPs;
      }
      
      // Generate public IPs
      public static String[] generatePublicIPs() {
            String[] publicIPs = new String[8];
            for (int i = 0; i < 8; i++) {
                  int ip = (int) (Math.random() * (0xFFFFFFFF)); // Random public IP address
                  publicIPs[i] = intToIp(ip);
            }
            return publicIPs;
      }
      
      public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            
            // Input for network details
            System.out.print("Enter the number of hosts: ");
            int hosts = scanner.nextInt();
            
            System.out.print("Enter the base IP address (in dotted decimal): ");
            String ipInput = scanner.next();
            String[] ipParts = ipInput.split("\\.");
            int ip = (Integer.parseInt(ipParts[0]) << 24) | (Integer.parseInt(ipParts[1]) << 16) |
                    (Integer.parseInt(ipParts[2]) << 8) | Integer.parseInt(ipParts[3]);
            
            // Calculate subnet mask and network ID
            int subnetBits = calculateSubnetBits(hosts);
            String subnetMask = calculateSubnetMask(subnetBits);
            String networkAddress = calculateNetworkAddress(ip, Integer.parseInt(subnetMask.replaceAll("\\.", ""), 16));
            String[] firstLastIP = calculateFirstLastIP(Integer.parseInt(networkAddress.replaceAll("\\.", ""), 16), hosts);
            
            // Output network information
            System.out.println("Network Mask: " + subnetMask);
            System.out.println("Network Address: " + networkAddress);
            System.out.println("First IP: " + firstLastIP[0]);
            System.out.println("Last IP: " + firstLastIP[1]);
            
            // Generate and print all IPs in the network
            String[] allIPs = generateAllIPs(Integer.parseInt(networkAddress.replaceAll("\\.", ""), 16), hosts);
            System.out.println("All IPs in the network:");
            for (String ipAddress : allIPs) {
                  System.out.println(ipAddress);
            }
            
            // Input for subnets
            System.out.print("Enter the number of subnets: ");
            int subnets = scanner.nextInt();
            
            // Generate subnets
            String[][] subnetsIPs = subnetting(Integer.parseInt(networkAddress.replaceAll("\\.", ""), 16), Integer.parseInt(subnetMask.replaceAll("\\.", ""), 16), subnets, hosts);
            System.out.println("Subnet IPs:");
            for (int i = 0; i < subnets; i++) {
                  System.out.println("Subnet " + (i + 1) + " IPs:");
                  for (String ipAddress : subnetsIPs[i]) {
                        System.out.println(ipAddress);
                  }
            }
            
            // Generate public IPs
            String[] publicIPs = generatePublicIPs();
            System.out.println("Public IPs:");
            for (int i = 0; i < publicIPs.length; i++) {
                  System.out.println("Public IP " + (i + 1) + ": " + publicIPs[i]);
            }
            
            scanner.close();
      }
}
