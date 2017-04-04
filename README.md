# Bootstrap component for aplynk

This is a basic component to start implementing your aplynk connectors.

## Update: 17th Feb 2017
Updated elastic.io sailor version to 2.0.0. There are some breaking changes due to this.
Here is a list of changes that needs to be made to make sure any new projects work.

1. Components no longer need a 1 parameter constructor. This is because event emitter is now provided in parameters. 
It is absolutely necessary to call `super.execute(params)` in your execute method. Or else there will be null pointer exception.

2. They have changed the default json library from gson to jersey-json. Due to this there will be issues getting data from params, as well as emitted. I've handled these cases in the BaseComponent, and added a few more accessor methods to get Config, Input and Snapshot. Try to use these at all cases.
 
3. I've also added a StandardComponent file in blueprints package. This can be copy pasted when creating new Components.
