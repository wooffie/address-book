# Java class "address book"
Class keeps a list of addresses of different people. Address consists of street , house , apartment number. Person is given by surname. One person has one address.
### Methods:
Put person with his address into address book. If adding is successful, method will return ***true***. If person contains in book, will return ***false***.
```
addHuman(String name, Address address)
```
Remove person from address book. If removing is successful, method will return ***true***. If person don't contains in book, will return ***false***.
```
deleteHuman(String name)
```
Change address of person. If address book don't contains recording about this person or new address same with old address, method will return ***false***. Otherwise will return ***true***.
```
changeAddress(String name, Address address)
```
Returns address of person. If address book don't contains recording about this person, method will return **null**.
```
findAddress(String name)
```
Returns persons who live on assigned street or house.
```
findPersons(String street)
findPersons(String street, int number)
```
Returns **Map<String, Address>** of all entries.
```
getData()
```
Overrides:
```
toString() 
hashCode() 
equals(Object o) 
```
## Class Address
### Fields:
```
String street
int number
int apartment
```
### Constructor:
```
Address(String street, int number, int apartment)
```
### Methods:
Return apartment:
```
getApartment()
```
Return nubmer:
```
getNumber()
```
Return street:
```
getStreet() 
```
Overrides:
```
toString() 
hashCode() 
equals(Object o) 
```
