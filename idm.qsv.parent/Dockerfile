FROM gradle:jdk11

COPY . .

RUN apt-get -y update
RUN apt-get install bsdmainutils -y  
RUN ln -s /usr/bin/python3 /usr/local/bin/python
RUN apt-get install -y python3-pip -y
RUN pip3 install pandas==1.1.4

RUN gradle shadowJar

RUN python benchmark.py

