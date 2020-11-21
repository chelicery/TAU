import logging


from selenium import webdriver

logger = logging.getLogger('simple_example')
logger.setLevel(logging.INFO)
logging.basicConfig(filename="selenium_1_1.log",
                    format='%(asctime)s %(message)s',
                    filemode='w')
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
ch.setFormatter(formatter)
logger.addHandler(ch)

driver = webdriver.Edge(executable_path='E:\downloads\edgedriver_win64\msedgedriver.exe')
# driverFirefox = webdriver.Firefox(executable_path='E:\downloads\geckodriver-v0.28.0-win64\geckodriver.exe')
# driverChrome = webdriver.Chrome(executable_path='E:\downloads\chromedriver_win32\chromedriver.exe')
logger.info('Przechodze na strone kurnik')
driver.get('https://www.kurnik.pl/')

temp = driver.find_element_by_partial_link_text('zaloguj')
logger.info('Przechodze na strone logowania')
temp.click()

temp = driver.find_element_by_xpath("//a[@class='lbut bxpad ttup']")
logger.info('Przechodze na strone rejestracji')
temp.click()

profilName = 'tau1234pj'
temp = driver.find_element_by_name('username')
temp.send_keys(profilName)

logger.warning('Nazwa uzytkownika musi byc unikalna')
temp = driver.find_element_by_id('pw1')
temp.send_keys('1234ab')
temp = driver.find_element_by_id('pw2')
temp.send_keys('1234ab')

temp = driver.find_element_by_class_name('minw')
temp.click()

temp = driver.find_element_by_class_name('fb')
fb_expected_value = '(tau1234pj) wybrana nazwa jest już zajęta; dodaj jakieś cyfry lub coś'
assert temp.text == fb_expected_value
logger.error(temp.text)

driver.close()