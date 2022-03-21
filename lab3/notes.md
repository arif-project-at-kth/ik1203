# LAB 3 

## Cisco IOS Command Hierarchy
- Two different access levels:
  1. user EXEC level. Basic monitoring commands.
  2. privileged EXEC level. Access all router commands, password protected to only allow only authorized user, configure or manage routers.
  There are five commands:
    1. Global configuration mode.
    2. Interface configuration mode.
    3. Subinterface configuration mode.
    4. Router configuration mode.
    5. Line configuration mode.

![Cisco IOS Software Hierarchy](#)

| Modes   | Description    |
|--------------- | --------------- |
| Router>   | User EXEC mode   |
| Router# | Privileged EXEC mode |
| Router(config)# | Configuration mode |
| Router(config-if)# | Interface level within configuration mode |
| Router(config-router)# | Routing engine level within configuration mode |
| Router(config-line)# | Line level (vty, tty, async) within configuration mode |


## Basic Router Configuration
> NOTE: We use Cisco 7301 routers with IOS 12.4T in our lab. Although the configurations in the examples above are for a different router model, they are still valid.

### Configuration Global Parameters
```bash
# STEP 1
# Enters global configuration mode.
Router> enable
Router# configure terminal

# STEP 2 
# Specifies the name for router.
Router(config)# hostname <hostname> 

# STEP 3 
# Specifies encrypted password.
Router(config)# enable secret <password> 

# STEP 4 
# Disables the router from translating unfamiliar words (typos) into IP addresses.
Router(config)# no ip domain-lookup
```


### Configuration Gigabit Ethernet LAN Interfaces
```bash
# STEP 1 
# Enters global configuration mode
Router# configure terminal

# STEP 2
# Enter configuration mode for Gigabit Ethernet interface on the router.
# Note Cisco C841M-8X ISR 0/0 to 0/7.
#      Cisco C841M-4X ISR 0/0 to 0/3.
# Router(config)# interface gigabitethernet <slot>/<port>
Router(config)# interface gigabitethernet 0/1 

# STEP 3 
# Router(config-if)# ip address <ip-address> <subnet-mask>
Router(config-if)# ip address 192.168.12.2 255.255.255.0

# STEP 4 
# Enables gigabitethernet interface, changing  its state from administratively down to administratively up.
Router(config-if)# no shutdown

# STEP 5 
# Exit configuration mode and returns to global configuration mode.
Router(config-if)# exit
```

### Configuring Static Routes 
```bash
# STEP 1 
# Enters global configuration mode.
Router# configure terminal 

# STEP 2 
# Router(config)# ip route <ip-address> <subnet-mask> <ip-address>
Router(config)# ip route 192.168.1.0 255.255.0.0 10.10.10.2 

# STEP 3 
# Exits router configuration mode and enters priviliged EXEC mode.
Router(config)# end
```

## Network toplogy
**X in ip-address is the __assigned number__ from previous lab**
> If person A has the number 234 and person B had 123. Person A is the Laptop 1 which means both will use ip-address 10.234.1.0/24. (for example).

Connected to Labs network management network using WiFi.

