# PerformanceDebugging

## System requirements:
* Window/Linux Operating System
* JAVA Development Kit 8
* Eclipse (Juno or latest)

## What you need to do to run this
1. Import the project in Eclipse
2. set your input in the `stacktrace.txt` file
3. run the `Main.java` file
4. you will find the output in the `output.txt` file

## Input file format
* `number of functions` `number of stacktraces`
* `index of the function` `name of the function` //for all the functions
* `space separated callstack of the stacktrace` //for all the stacktraces

The example is [here](https://github.com/IITDU-AMIT-MSSE1044/course-project-AwatifYasmin/blob/master/stacktraces.txt)

## Output file format
* frequent subsequence (indexes of the functions, -1 as the end of the subsequence)
* #SUP: number of callstacks contains this subsequence
* #SID: indices list of the callstacks contains this subsequence

The example is [here](https://github.com/IITDU-AMIT-MSSE1044/course-project-AwatifYasmin/blob/master/output.txt)

## Base project
StackMine has been applied in performancce debugging activities at a Microsoft team for performance analysis, espacially for a large number of executive traces by calculating their cost.
## My project
In my project i calculated the frequency of the sequences and cluster them. Then calculated their cost as the base project did.

I didn't extended the existing project.
