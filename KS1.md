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
