
## Tracking:
- [X] Menu
- [X] Lesson 7: Unit Testing
- [X] Lesson 8: GUI
- [X] Lesson 9: Streams and Filters
- [X] Lesson 10: Design Patterns
- [X] Lesson 11: Concurrency
- [X] Checklist

## Checklist:
	- all classes with @author tags?
	- any magic numbers?
	- consistent curly bracket style?
	- variable names without numbers or letters
	- are all parameters final?

	
## Open Questions:
	- Menu:
		- Issue: I assumed he's describing a text-based menu. The only time we see a GUI is when calling the first option "1"
		Q: Is this really the case? Did he maybe meant that we needed to create a GUI with buttons?
		
	- CountryProcessor: 
		- Issue: His requirement "in all cases, before printing, collect the result into a java collection local variable"
		Q: Can .max and .min with "Optional<>" be categorized as "collecting"? 
		
		- Issue: printAllCapitalsThatContainLetterIntoASingleStringNoSpaces lists countries in its example. 
		Q: Is the example inaccurate? Should we go with capitals or with countries?
		
		- Issue: Which letter should be the last character for the country Congo... Republic of the?
		Q: Sounds like it should be "o" but should we care about this?
		
	- Design Patterns and Concurrency:
		- Issue: Both of these parts in the assignment were too easy. 
		Q: Did I misinterpret the task? When he says "implement" I assumed he wants us to put it into effect. Is he expecting us to change their purpose of the examples in any way?
		
## Bugs:
	- GUI:
		- GUI portion is sometimes not populated - (even though scanner successfully read the file)
		Frequency: UNCOMMON 
		Solution: Stopped happening after I called "jListModel.size()"? Schrodinger's bug?