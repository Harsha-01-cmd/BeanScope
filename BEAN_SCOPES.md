# Spring Bean Scopes — Quick Reference

## Singleton Scope (Default)
- **One instance per container**
- Spring caches the instance after first creation
- Use for **stateless** beans: services, repositories, controllers

```java
@Scope("singleton")  // redundant — singleton is the default
public class OrderService { }
```

## Prototype Scope
- **New instance every time** `getBean()` is called
- Spring does NOT manage the full lifecycle after creation
- Use for **stateful** beans: form objects, domain models

```java
@Scope("prototype")
@Component
public class UserForm { }
```

## Quick Comparison

| Aspect | Singleton | Prototype |
|--------|-----------|-----------|
| Instances | One per container | New per request |
| Lifecycle | Fully managed by Spring | Created by Spring, destroyed by caller |
| Best for | Services, repos, controllers | Forms, commands, domain models |

## Common Pitfall: Injecting Prototype into Singleton
```java
@Service  // singleton
public class OrderService {
    @Autowired
    private UserForm userForm;  // prototype — only injected ONCE!
}
```
**Solution:** Use `ObjectFactory<UserForm>` to get a new instance each call.
