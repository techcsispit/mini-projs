# create a virtual environment
python3 -m venv venv

# activate the virtual environment
source venv/bin/activate

# install the required packages from requirements.txt
pip install -r requirements.txt

# run the Python file
python full body detection.py

# if you want to use webcam uncomment line 11 otherwise change the line 9 to the video's path
