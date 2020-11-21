import logging
import time
from selenium import webdriver
from selenium.common.exceptions import NoSuchElementException
from selenium.webdriver.common.keys import Keys

logger = logging.getLogger('selenium_2_1_logger')
logging.basicConfig(filename="selenium_2_1.log",
                    format='%(asctime)s %(message)s',
                    filemode='w')

logger.setLevel(logging.INFO)
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
ch.setFormatter(formatter)
logger.addHandler(ch)


#konfiguracja ścieżki do webdrivera,
driver = webdriver.Chrome(executable_path='E:\downloads\chromedriver_win32\chromedriver.exe')

logger.info('wchodze na strone https://www.zooplus.pl/shop/psy/karma_dla_psa_sucha/brit')
driver.get('https://www.zooplus.pl/shop/psy/karma_dla_psa_sucha/brit')


logger.info('doadje do koszyka')
temp = driver.find_element_by_class_name("btn.btn-secondary.solo-icon")
temp.click()

logger.info('dprzechodze do koszyka')
temp = driver.find_element_by_class_name("cart-label")
temp.click()
time.sleep(1)
logger.info('zwiekszam ilosc produktu w koszyku')
temp = driver.find_element_by_xpath('/html/body/div[8]/div[1]/div[2]/div[2]/div[3]/form/div/input')
temp.send_keys(Keys.BACKSPACE)
temp.send_keys(10)
temp.send_keys(Keys.ENTER)

logger.info('usuwam produkty z koszyka')
temp = driver.find_element_by_class_name('remove__item')
temp.click()

value = driver.find_element_by_xpath('/html/body/div[8]/div[2]/h1')

assert value.text == 'Twój koszyk jest pusty'

#driver.close()