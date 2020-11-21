import logging

from selenium import webdriver

logger = logging.getLogger('simple_example')
logging.basicConfig(filename="selenium_1_2.log",
                    format='%(asctime)s %(message)s',
                    filemode='w')

logger.setLevel(logging.INFO)
ch = logging.StreamHandler()
ch.setLevel(logging.DEBUG)
formatter = logging.Formatter('%(asctime)s - %(name)s - %(levelname)s - %(message)s')
ch.setFormatter(formatter)
logger.addHandler(ch)


driver = webdriver.Firefox(executable_path='E:\downloads\geckodriver-v0.28.0-win64\geckodriver.exe')
# driverChrome = webdriver.Chrome(executable_path='E:\downloads\chromedriver_win32\chromedriver.exe')
logger.info('Przechodzę na stronę kurnik')
driver.get('https://www.kurnik.pl/')

temp = driver.find_element_by_partial_link_text('zaloguj')
logger.info('Przechodzę na stronę logowania')
temp.click()

logger.info('Uzupełniam dane formularza ')
temp = driver.find_element_by_name('username')
temp.send_keys('tau1234pj')
temp = driver.find_element_by_name('pw')
temp.send_keys('1234ab')

logger.info('Podsumowuje formularz')
temp = driver.find_element_by_xpath("//input[@value='zaloguj >']")
temp.click()

logger.info('Klikam na swoje konto')
temp = driver.find_element_by_xpath("/html/body/div[1]/div[2]/span/select/option[3]")
#assert temp == 'tau1234pj'
temp.click()


logger.info('jeżeli zostałem przeniesiony na profil to zostałem zalogowany')
temp = driver.find_element_by_xpath("/html/body/h1")
assert temp.text == 'profil'

# driver.close()