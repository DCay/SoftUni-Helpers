# Dynamic Form Field Adding

## This is a simple functionality of dynamically adding fields to a form. 

* The algorithm is simulated with images.
* Clicking on the upload button uploads an image, setting it as a background of the parent element of the input field.
* Afterwards, the input field is hidden, and another input field is dynamically attached to the form, with its own parent element.
* When 4 images are uploaded, a new row is created, so that the miniature design that is implemented does not break horribly.
* There is also functionality for preloading images, but it is most likely only appliable with server-side rendering.
* The JavaScript that is used to implement the functionality is briefly documented.

## A Back-End Endpoint handler for the implemented form would look like this:

### C# Syntax Example (ASP.NET Core)

```csharp
[HttpPost]
public void Post([FromForm] string name, [FromForm] decimal price, [FromForm] List<IFormFile> images)
{
	// TODO: Do magic here.
}
```

### More examples may be added in the future...