
FROM alpine:3.11

ENV PYTHONUNBUFFERED=1

RUN echo "**** install Python ****" && \
    apk add --no-cache ca-certificates python3 python3-dev make gcc g++ libffi-dev openssl-dev && \
    if [ ! -e /usr/bin/python ]; then ln -sf python3 /usr/bin/python ; fi && \
    \
    echo "**** install pip ****" && \
    python3 -m ensurepip && \
    rm -r /usr/lib/python*/ensurepip && \
    pip3 install --no-cache --upgrade pip setuptools wheel && \
    if [ ! -e /usr/bin/pip ]; then ln -s pip3 /usr/bin/pip ; fi

COPY . /app
COPY ./module /app/module
COPY ./keyfile /app/keyfile

WORKDIR /app

RUN pip install --no-cache -r requirement.txt

EXPOSE 80

CMD ["python","app.py"]

# curl --data '{"project":"jaypark-mz-sandbox-200513"}' -H "Content-Type: application/json" http://127.0.0.1/instances/get