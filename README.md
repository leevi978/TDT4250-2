# TDT4250-2

## Adding linear conversions
In the OSGi gogo shell, 
```
addConversion FROM_UNIT TO_UNIT "EXPRESSION"
```
where EXPRESSION is the linear conversion expression, with x substituted for the unit to convert from

E.g.
```
addConversion Fahrenheit Celcius "(x - 32) * 5/9"
```
