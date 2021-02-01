import requests
import json
url = "https://api.punkapi.com/v2/beers"
response = requests.get("https://api.punkapi.com/v2/beers")

def test_connect_to_api():
    assert response.status_code == 200

def test_bad_request():
    response = requests.get("https://api.punkapi.com/v2/beers/id/1")
    assert response.status_code == 404

def test_keys():
    expected = ["id", "name", "description"]
    current = []
    a = json.loads(response.text)
    a = a[0]
    for k in a:
        if k in expected:
            current.append(k)
    assert expected == current

def test_values():
    test_beer_id = 1
    expected_beer_name = "Buzz"
    current = "Gruzz"
    a = json.loads(response.text)
    a = a[0]
    for key, value in a.items():
        print(key, value)
        if key == "name" :
            current = value
    assert expected_beer_name == current