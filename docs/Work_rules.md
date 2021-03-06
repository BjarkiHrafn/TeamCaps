Work rules
==========

Concerning git operations
-------------------------
>
> ### commit 
> 
> * All comments are written in english.
> * All comments should be descriptive and short.
		 
> ### add
> 
> * The command "git add ." should only be used if working on a file that is not on github.com.
> * Instead the command "git add -p" should be used.
		 
Concerning coding practices and rules
-------------------------------------
>
> ### code
> 
> * This projects code is scanned automatically for code format errors that follows [Google java code format](https://google.github.io/styleguide/javaguide.html).

> #### code example from google java format
> ```javascript
> return () -> {
>  while (condition()) {
>    method();
>  }
>};
>
>return new MyClass() {
>  @Override public void method() {
>    if (condition()) {
>      try {
>        something();
>      } catch (ProblemException e) {
>        recover();
>      }
>    } else if (otherCondition()) {
>      somethingElse();
>    } else {
>      lastThing();
>    }
>  }
>};
> ```


