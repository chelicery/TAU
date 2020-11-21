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
time.sleep(1)
logger.info('przechodze do koszyka')
temp = driver.find_element_by_class_name("cart-label")
temp.click()

logger.info('zwiekszam ilosc produktu w koszyku')
temp =driver.find_element_by_class_name('v3-counter__input.js-txtCounter')
temp.send_keys(Keys.BACKSPACE)
temp.send_keys(10)
temp.send_keys(Keys.ENTER)


price_from_site = driver.find_element_by_xpath('/html/body/div[10]/div[1]/div[2]/div[2]/div[4]')
total_price_from_site = driver.find_element_by_class_name('total__price.v3-text--right')
price = price_from_site.text
price = str(price).replace('zł', '')

total_price = total_price_from_site.text
total_price = str(total_price).replace('zł','')

assert price == total_price


#driver.close()