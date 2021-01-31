# add_test.rb
require "test/unit"
require_relative './add'

class AddTest < Test::Unit::TestCase
  def test_world
    assert_equal 3, Add.add(1,2), "1 + 2 = 3"
  end

end
