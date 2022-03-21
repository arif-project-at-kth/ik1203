# Preparation for KS1

## Introduction 
- Protocols, control sending and receiving of messages. [TCP, IP, HTTP, Skype, IEEE 802.11 WLAN]
  - Protocols define format and order of messages sent and received among network entities, and actions taken on message transmission and reception.
  ![Human protocol vs Network protocol](https://netlab.ulusofona.pt/rc/book/1-introduction/1_02/01-02.jpg)
  - Human protocol, network protocols.
- Internet standards, [Request for comments(RFC), Internet Engineering Task Force(IETF)]
- Service view, (1) Infrastructure that provides services to applications. (2) Provides programming interface to applications.
- Network structure, (1) network edge, (2) access networks, physical media, (3) network core.
  - When a host is sending a message the message is broken down to smaller `packets` of length `L` bits. 
  The packets are send via links into access network.
  Packets are transmitted one bit at a time at a certain rate R.
  The formula for `packet transmission delay = time needed to tansmit a packet with L bits into link = ` ![packet transmission delay](http://www.sciweavers.org/upload/Tex2Img_1643976583/render.png)
  1. Hosts can be clients or servers.
  2. Wired or wireless communication links.
  3. Interconnected routers and network of network.
- Transmission and Propagation delay
  - Transmission delay is when you are waiting for a response back fron the oter clients.
  - Propagation delay is when the receiever is waiting for your message.
- Access Network, can be divided into two groups. (1) Local access, (2) Internet access. (1) and (2) are connected via a router.
  - Local access, contains clients, Ethernet switch. [Wireless Local Area Network(WiFi), Ethernet (Wired LAN)]
  - Internet access, contains the link to Internet Service Provider (ISP). [Digital Subscriber Line(xDSL), Optical Fiber, Data Over Cable Service Interface Specification(DOCSIS), Wireless broadband]
- Packet switching: **Store-and-forward**, entire packet must arrive at a router before it can be transmitted on a next link.
- **Internet protocol stack** have five layers. (1) Application, (2) Transport, (3) Network, (4) Link, (5) Physical.
1. Support network applications. [File transfer Protocol(FTP), Simple Mail Transfer Protocol(SMTP), Hypertext Transfer Ptocol(HTTP)]. Rules for communication between processes on different hosts that together make up an application.
2. Process-process data transfer. Provide communication between application processes on different hosts. [Transmission Control Protocol(TCP), User Datagram Protocol(UDP)].
3. Routing of datagrams from source to destination. [IP, routing protocols] Provides support for communication between hosts, via any routers in between.
4. Data transfer between beigboring network elements. [Ethernet, IEEE 802.11 (WIFI), PPP]. Provides support for communication between directly connect routers or hosts.
5. bits "on the wire". Defines for instance electrical and optical properties.


## Application Layer
- Application architectures, (1) client-server, (2) peer-to-peer(P2P).
1. Can divide the architecture into two parts, server and clients.
  - Server, allwas-on host, permanent IP address.
  - Clients, communicate with server, dynamic IP addresses.
2. No always-on server. Self scalability as it request services from peers.
- Processes communicating, **client process**: process that initiates communication. **server process**: proceess that waits to be contacted.
- **What transport service does an application need?** [data integrity, timing, throughput, security]
  - Data integrity, require __100%__ reliable data for FTP, web transactions. Other applications can tolerate some loss.
  - Timing, some applications can require low delay such as games.
  - Throughput, multimedia require certain minimum amount of throughput. other aren't strict.
  - Security, Encryption, data integrity.

- Request Method types. [HTTP/1.0, HTTP/1.1, HTTP/2]
  - HTTP/1.0,  = GET, POST, HEAD
  - HTTP/1.1, += PUT, DELETE, HTTP is a text-based protocol(not binary), which means that HTTP requests and responses are transmitted in text format. Each web object (page , image, movie, etc.) has a unique identifier hat can be used to address the object. By using web caches it is possible to reduce the response time for client requests.
  - HTTP/2.X   = More HTTP transfer per page, more data per transfer, Request/response stop-and-wait. TCP Efficiency (Congestion control, Redundancy with same information, Stop-and-wait nature of TCP handshakes. Multiplexing to support loading of multiple objects at the same time over single connection.
- Mail access protocols. SMTP -> [POP, IMAP,  HTTP]
  - POP, Post Office protocol: authorization, download.
  - IMAP, Internet Mail Access Protocol: more features, including manipulation of stored msgs on server.
  - HTTP, gmail, Hotmail, Yahoo! Mail, etc.

- Domain Name System, DNS. [Distributed database, application-layer protocol]
- Asymmetric digital subscriber line(ADSL), physical line
- Data Over Cable Service Interface Specification(DOCSIS), is an international telecommunications standard that permits the addition of high -bandwith data transfer to an existing cable television (CATV) system.
- Internet Exchange Point, IXP
  - A meeting place where ISPs connect to each other.
- Tier 1 ISP
  - Often has intentional coverage
  - Have mutal agreements for exchanging traffic with each other, free of charge ("peering agreements").
- Access ISP
  - Connects to the end user (home, company, university, etc)
  - Is usually a customer of one (or more) Tier 1 ISP, and is being charged for sending and receiving traffic.
- P2P
  - A P2P network has no predefined structure. Instead it is formed dynamically by the nodes ("peers") that for the moment are participating in the network (charing a file, for instance)
  - P2P networks rely on principle that users make their resources available for sharing (resources for stage, communication, processing, etc)



## Transport Layer
### Which of the following statements about TCP are correct?
- The retransmission timeout used by TCP depends partly on the distance between sender and receiver.
- TCP includes mechanisms both for flow control and congestion control.
- Before data can be transmitted, a connection has to be established.
- The flow control used by TCP normally gives superior performance compared to stop-and-wait.

### Which of the following statements about DNS are true? 
- An authoritative DNS server knows the answers to queries about names in the domain for which it is responsible ("kth.se", for example).
- A DNS server uses caching to be able to answer queries faster.
- An organization's local DNS server (or default name server) helps other computers within the organization to resolve DNS queries.
- Each organization, company, etc., that has a domain name is also responsible for answering DNS queries about its domain.

### Which of the following statements about TCP congestion control are correct?
- During the slow start phase, the congestion window increases exponentially in size.
- During the congestion avoidance phase, the congestion window increases linearly in size.

### Question 4
Assume a reliable transport protocol of the same kind as described in the course book and the lectures (rdt 3.0 in the book), and that the protocol must work over a network where both bit errors and packet loss can occur.
This protocol uses several mechanisms to detect and deal with the errors above, mainly timers, sequence numbers, checksums, and acknowledgements (ACKs).
- We can deal with packet loss through the use of sequence numbers, ACKs, and timers. Checksums are not needed.
- It is sufficient with checksums, ACKs, and sequence numbers to deal with bit errors (in data and ACKs). Timers are not needed

### TCP is connection oriented, which means that it has to deal with connection estblishment and termination. Which of the following statements are true? 
- When a TCP connection is being established, the very first segment sent is a TCP SYN segment.
- When TCP closes a connection, it normally uses a 4-way handshake.

### Question 6
TCP and UDP are both transport layer protocols, but they operate very differently.

Which of the following alternatives are correct?
-  A UDP sender can "starve out" a TCP sender from the network.
- UDP can protect data with a checksum, but does not always do that.
- A server supporting both TCP and UDP can use the same port number for communicating with one client over UDP and another client over TCP.

### Question 7
We have studied two different protocols for flow control: Go-Back-N and Stop-and-wait.

Below is a list of properties. Choose the protocol(s) for which the property is valid.
#### Go-Back-N
- Requires the sender to buffer multiple packets.
- Packet loss can require retransmission even of serveral correctly delivered packets.
- Use "cumulative ACKs"

#### Stop-and-Wait
- Normally gives lowest utilzation of available network capacity.
- Two sequence numbers are sufficient.

### Question 8
Assume we have a transport level connection with a **capacity of 8 Mbit/s** and that the delay between sender and **receiver is 5 ms** (one-way).

Which is the optimal window size in bytes that the sender should use?

Hint: calculate the bandwidth-delay product.

Answer in number of bytes (not kB, not bits). Give only the value without units as your answer.

#### Answer
Optimal window size = capacity x RTT = 8 Mbit/s x 10ms (=5ms (one-way) * 2) = 10_000 bytes

### DNS can be seen as a distributed database. What kind of lookup operations (or translations) are supported by DNS? 
- Name to IPv6 address
- Name to name
- Name to IPv4 address
- Name to mail server
- Name to authoritative DNS server

###  Web cookies, or HTTP cookies, are used by many web servers, for different purposes. Which of the following statements about web cookies are true? 
- Cookies are created by the web server and stored in the web client.
- By using cookies, a web server can keep track of when a user last visited the site.
- By using cookies, web servers can for instance keep track of user-specific information, such as shopping baskets.

###  You have just started your computer and the first thing you do is to open a web browser to visit the site "www.kth.se". Which  application and transport layer protocols need to be involved in order to fetch the web page to your browser? 
- DNS
- TCP
- UDP
- HTTP
- 
DNS over UDP to translate the domain name to an IP address, HTTP over TCP to fetch the web page.
