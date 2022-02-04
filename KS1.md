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
1. Support network applications. [File transfer Protocol(FTP), Simple Mail Transfer Protocol(SMTP), Hypertext Transfer Ptocol(HTTP)]
2. Process-process data transfer. Provide communication between application processes on different hosts. [Transmission Control Protocol(TCP), User Datagram Protocol(UDP)]
3. Routing of datagrams from source to destination. [IP, routing protocols]
4. Data transfer between beigboring network elements. [Ethernet, IEEE 802.11 (WIFI), PPP]
5. bits "on the wire".


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
  - HTTP/1.1, += PUT, DELETE
  - HTTP/2.X   = More HTTP transfer per page, more data per transfer, Request/response stop-and-wait. TCP Efficiency (Congestion control, Redundancy with same information, Stop-and-wait nature of TCP handshakes. Multiplexing to support loading of multiple objects at the same time over single connection.
- Mail access protocols. SMTP -> [POP, IMAP,  HTTP]
  - POP, Post Office protocol: authorization, download.
  - IMAP, Internet Mail Access Protocol: more features, including manipulation of stored msgs on server.
  - HTTP, gmail, Hotmail, Yahoo! Mail, etc.

- Domain Name System, DNS. [Distributed database, application-layer protocol]



## Transport Layer
