# Starter Project to Implement Queue

Uses ActiveMq

### Project Description
Creates basic queue functionality. Supplier will provide three parameters to the queue:

- Receiver Email Address
- Type of Email
  
    - REGISTRATION : Sent after successful registration
    - PASSWORDRESET: Sent for password reset
    - SUBSCRIPTION:  Sent for general subscription
    - CUSTOMEMAIL:   Custom email types

- Sender Email Address: Can be custom or can use default
    

### TODO

- [ ] Create Producer, Consumer

- [ ] Implement DB module with Guice Injection

- [ ] Add template support

- [ ] Add email support

- [ ] Generify

- [ ] MultiThread

- [ ] CI/CD support