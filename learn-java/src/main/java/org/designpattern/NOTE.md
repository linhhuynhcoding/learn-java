### NOTEBOOK

Definition: The Strategy Pattern is a design pattern used to define a family of algorithms, encapsulate each one, and make them interchangeable. The main idea is to allow the algorithm to vary independently from the clients that use it.

When to Use: It’s typically used when you have different algorithms or behaviors that can be selected at runtime, and you want to avoid conditional statements or redundant code.

Key Benefit: Promotes the Open/Closed Principle by allowing you to introduce new strategies without changing the code that uses the strategies.

<img src="https://upload.wikimedia.org/wikipedia/commons/3/39/Strategy_Pattern_in_UML.png">

Example: If you’re building a payment processing system, you could use the Strategy Pattern to select different payment methods (credit card, PayPal, etc.) based on user preference.

#### 2. Observer 
the observer pattern is a software design pattern in which an object, named the subject, maintains a list of its dependents, called observers, and notifies them automatically of any state changes, usually by calling one of their methods.

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Observer_w_update.svg/500px-Observer_w_update.svg.png">