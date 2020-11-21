import logging

from selenium import webdriver

logger = logging.getLogger('simple_example')
logger.setLevel(logging.INFO)
logging.basicConfig(filename="selenium_1_2.log",
                    format='%(asctime)s %(message)s',
                    filemode='w')

ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
ch.setFormatter(formatter)
logger.addHandler(ch)

driver = webdriver.Firefox(executable_path='E:\downloads\geckodriver-v0.28.0-win64\geckodriver.exe')
# driverFirefox = webdriver.Firefox(executable_path='E:\downloads\geckodriver-v0.28.0-win64\geckodriver.exe')
# driverChrome = webdriver.Chrome(executable_path='E:\downloads\chromedriver_win32\chromedriver.exe')
logger.info('Przechodze na strone kurnik')
driver.get('https://www.kurnik.pl/')

temp = driver.find_element_by_partial_link_text('zaloguj')
logger.info('Przechodze na strone logowania')
temp.click()

logger.info('Uzupelniam dane formularza ')
temp = driver.find_element_by_name('username')
temp.send_keys('tau1234pj')
temp = driver.find_element_by_id('pw')
temp.send_keys('1234ab')

logger.info('Podsumowuje formularz')
temp = driver.find_element_by_value('submit')
temp.click()


driver.close()