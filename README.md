# JSON Schema Validator Prototype

This repository contains a prototype version of a validator using [JSON Schema](http://json-schema.org/)
 at this point in version `draft-06` (the next version, _draft-07_, is in the final feedback month before publication).
 
This validator has a central structure, the `Json Schema Validator`. It has been implemented twice using two different Java libraries:
 
 * [json-schema](https://github.com/everit-org/json-schema) (1.6.0)
 * [json-schema-validator](https://github.com/java-json-tools/json-schema-validator) (2.2.8)
 
 The first goal is to evaluate both libraries and assess which one better accomplishes our needs. 
 Beyond that we also want to evaluate how can we implement certain validation rules in JSON Schema.
 
 ## License
 For more details about licensing see the [LICENSE](LICENSE.md).