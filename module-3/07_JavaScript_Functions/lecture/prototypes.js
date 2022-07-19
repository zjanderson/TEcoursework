/*
    JavaScript uses a style of object-oriented programming based on prototypes.
    This is sometimes referred to as prototypal.

    Objects inherit directly from other objects through a prototype.

    All objects inherit from the Object prototype, and Object has a prototype of null.
*/

// Let's first discuss how to create objects, including how to create 
// properties, methods, and static vs. instance. 
// There are several ways to do this.

// 1) Object literal creates a single instance of this object and inherits
// from Object.
const object = { 
    property1: 'value 1',
    property2: 'value 2',
    method1() {
        // do stuff here
    }
};

// 2) Use an existing object as a prototype.
// Creates a new object that inherits from the object above.
const newObject = Object.create(object);

// 3) Constructor function and new operator used below to create multiple 
// instances of MyObject. MyObject inherits from Object.
function MyObject(parameter1) {
    // public instance properties and methods.
    // public items are prefaced with this.
    this.property1 = parameter1,
    this.method1 = function() {
        console.log(privateProperty)
    },

    // private instance fields and methods
    privateProperty = parameter1 + 1,
    privateMethod = function() {
        // private method
    }
};

MyObject.staticMethod = function() {

}

const myObjectInstance1 = new MyObject("blah blah blah");
const myObjectInstance2 = new MyObject("blah blah blah");
// access instance properties/methods
myObjectInstance1.method1();
myObjectInstance1.property1;

// call static method 
MyObject.staticMethod();

// 4) Classes (syntactic sugar for what you see above)
class MyClass {
    #property1; // private instance property
    publicData; // public instance property
    static staticProperty; // public static property

    constructor(parameter1) {
        this.#property1 = parameter1;
        this.publicData = "blah blah";
    }

    static staticMethod() {
        // static method
    }

    #doStuff() {
        // private instance method
    }

    // public instance method
    getProperty1() {
        return this.#property1;
    }
}

const myClassInstance1 = new MyClass('hello world');


/*
    Now let's look at prototypes
*/

// Extend an object from a prototype

const myPrototype = { 
    parent: 'parent'
};

const myNewObject = {
    child: 'child'
};

Object.setPrototypeOf(myNewObject, myPrototype);

console.log(myNewObject.child);
console.log(myNewObject.parent);

// The parent of myNewObject is myPrototype
console.log(Object.getPrototypeOf(myNewObject) === myPrototype); // true

// The parent of myNewObject's parent is Object
console.log(Object.getPrototypeOf(Object.getPrototypeOf(myNewObject)) === Object.getPrototypeOf(new Object())); // true


// Do the same thing with classes
class MyParentClass {
    parent = 'parent';
}

class MyChildClass extends MyParentClass {
    child = 'child';
}

// Add properties or methods to an object, even after creation of instances, 
// by updating the prototype.

const myChild1 = new MyChildClass();
const myChild2 = new MyChildClass();

MyChildClass.prototype.newProperty = 123;

console.log(myChild1.newProperty);
console.log(myChild2.newProperty);
