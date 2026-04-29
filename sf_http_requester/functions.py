import requests
from screens import *

def request_status(API: str) -> str:
    try:
        response = requests.get(API)
        print(f"Código: {response.status_code}")
    except requests.exceptions.RequestException as e:
        print(f"Error: {e}")