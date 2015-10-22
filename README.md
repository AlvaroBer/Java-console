# Java Console class v 0.1
The purpose of this class is to help to print default Java's objects in the console, for example, the class can print HashMap and ArrayList objects.

These are the object types that, at the moment, are available.

* ArrayList
* HashMap
* Array





# Main examples
These are a few usage examples of Console class

##### log method

Code
```
Console console = new Console();

HashMap<String, Integer> map = new HashMap<String, Integer>();

map.put("key1", 1);
map.put("key2", 120);
map.put("key3", 15);

console.log(map);
```

Result
```
{key3: 15, key2: 120, key1: 1}
```
