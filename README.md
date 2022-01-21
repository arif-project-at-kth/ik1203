# IK1203 - Networks and Communication
VT2022  

## Computer Networking, Global Edition, 7e. James F. Kurose & Keith W. Ross. Pearson
ISBN-13: 9781292153599  

### Chapter 1.1 What is the Internet?
- 'hosts', 'end systems' 
- End systems, are connected together by a network of 'communication links' and 'packet switches'. 
- Communication links, are made up of different types of physical media and things like 'cable', 'copper wire', 'optical fiber'. 
These links can transmit data at different rates. 
'Transmission rate' of a link measured in bits/second. 
- 'Packets' are what's used to send information from one *end system* to another *end system*.
- Packet-Switch, the two most prominent types in today's Internet are 'routers', 'link-layer switches'. 
**Routers** are used in the network core and **link-layer switches** are used in access networks. 
- Internet Service Providers, ISPs, used by end systems to access the Internet. 
ISPs, are itself a network of packet switches and communication links.
- Protocol, controls the sending and receiving of information within the Internet. 
'Transmission Control Protocol, TCP' and 'Internet Protocol, IP' are the two most important protocols in the Internet. 
- IP protocol specifies the format of the packets that are sent and received among routers and end systems. 
The 'Internet's principal protocols are collectively known as '**TCP/IP**'. 
It's important to have a standard when communicating with other systems. 
**Request for comments. RFCs**, is the standard documentation which was developed by the 'Internet Engineering Task Force, IETF'. 
- RFCs, have documentation for 'TCP', 'IP', 'HTTP, for Web' and 'SMTP, for e-mail'. 
- IEEE 802 LAN/MAN standards Committee, have  documentation for the Ethernet and wireless WiFi standards. 
- '**Socket interface**', used in end system for specify how a program running on one end system asks the Internet infrastructure to deliver data to aspecific destination program running on another end system. 
Socket interface is a set of rules that the sending program must follow so that the Internet can deliver the data to destination program. 

> A **protocol** defines the format and the order of messages exchanged between two or more communicating entities, as well as the actions taken on the transmission and/or receipt of a message or other event.

### Chapter 1.2 The Network Edge
- Hosts, are also a end system, it referred to what entity it host application programs such as Web browswer program, a Web server program, an e-mail client program etc. 
- Hosts, can be divided to smaller sub groups, 'clients' and 'servers'. 
**Clients**, can be associated with 'desktop', 'mobile', 'PCs', 'smartphones'. 
**Servers**, can be associated with machines that are more powerful that store and distribute. 
#### Chapter 1.2.1 Access Networks
TBA
### Chapter 1.3 The Network Core
The Network Core, the mesh of packet switches and links that interconnects the Internet's end systems. 

#### Chapter 1.3.1 Packet Switching
In a network application, end systems exchange 'messages' with each other. 
Messages can be anything the application designer wants.
Most packet switches use 'store-and-forward transmission' at the input to the links. 
'**Store-and-forward transmission**' means that the packet switch must receive the entire packet before it can begin to transmit the first bit of the packet onto the outbound link. 

<!-- TODO -->
![store-and-forward transmit](http://www.sciweavers.org/upload/Tex2Img_1642773029/render.png) 

#### Chapter 1.3.3 A Network of Networks
### Chapter 1.4 Delay, Loss and Throughput in Packet-Switched Networks 
#### Chapter 1.4.1 Overview of Delay in Packet-Switched Networks
#### Chapter 1.4.2 Queuing Delay and Packet Loss 
#### Chapter 1.4.3 End-to-End Delay
#### Chapter 1.4.4 Throughput in Computer Networks
### Chapter 1.5 Protocol Layers and Their Service Models 
