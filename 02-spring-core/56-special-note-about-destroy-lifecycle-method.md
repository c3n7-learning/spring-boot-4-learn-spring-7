# Special Note about Prototype Scope - Destroy Lifecycle Method

There is a subtle point you need to be aware of with "prototype" scoped beans.

**For "prototype" scoped beans, Spring does not call the destroy method. Gasp!**

---

_**In contrast to the other scopes, Spring does not manage the complete lifecycle of a prototype bean:** the container instantiates, configures, and otherwise assembles a prototype object, and hands it to the client, with no further record of that prototype instance._

_Thus, although initialization lifecycle callback methods are called on all objects regardless of scope, **in the case of prototypes, configured destruction lifecycle callbacks are not called**. The client code must clean up prototype-scoped objects and release expensive resources that the prototype bean(s) are holding._
