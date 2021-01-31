# Lab 5 - Testing framework Ruby Test::Unit


## About
test-unit is a xUnit family unit testing framework for Ruby. 

Test::Unit provides a complete testing suite for your needs - supporting TDD, BDD, mocking, and benchmarking.

## Features

  - test-unit, it is standard ruby library what means it is included in Ruby language, it is beeing distributed as a gem also.
  - Some features exist as separated gems like GUI test runner. (Tk, GTK+ and Fox) test-unit-full gem package provides for installing all test-unit related gems easily.

## Setup
1. You need to have Ruby installed. There is easy Windows Ruby installer https://rubyinstaller.org/downloads/. For this toutorial I used 2.7.2-devkit. 

2. The easiest way for simple Ruby testingon Windows is running command prompt [cmd] with Ruby. It's feature attached to Ruby Devkit, installed above. 

![Imgur](https://i.imgur.com/2ytj6mW.png)

3. Run gem install on cmd with ruby:
```cmd
gem install test-unit
```

## How to run
Tests can be created as standalone files and must ends with _test.rb
```cmd
cd your/test/folder/path/
ruby example_test.rb
```

## How to use Unit::Test

Setting up Unit::Test is very easy, our class need to inherit methods from Test::Unit, so we need to do " Add < Test::Unit" in class declaration.

Unit::Test provides many Assertion functions like well known 'asser_equal' or 'asser_match'
Assert functions needs two parameters:
- boolean what is our test output
- message what is optional 
f.e. 
```
# simple.rb
require "test/unit/assertions"
include Test::Unit::Assertions

x = true

assert x, "x should pass"

```

Above is simple test when we tests if x is true.

Let's make some more complex tests:
We're going to make some simple class and adding method:
```
# add.rb
class Add
  def self.add(a, b)
    a + b
  end
end

```

and simple asser_equal test:

```
# add_test.rb
require "test/unit"
require_relative './add'

class AddTest < Test::Unit::TestCase
  def test_world
    assert_equal 3, Add.add(1,2), "1 + 2 = 3"
  end

end

```

Output: 

![Imgur](https://i.imgur.com/zu1hzo0.png)

As you see, Test::Unit is simple as Ruby language. 





## Useful Links

[Ruby](https://www.ruby-lang.org/en/)

[Test::Unit doc](https://www.rubydoc.info/gems/test-unit/2.3.1/Test/Unit)

[Test::Unit Github](https://github.com/test-unit/test-unit)
