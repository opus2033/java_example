import datetime as pydatetime

def get_now():
    """
        현재 시스템 시간을 datetime형으로 반환
    """
    return pydatetime.datetime.now()

def get_now_timestamp():
    """
        현재 시스템 시간을 POSIX timestamp float형으로 반환
    """
    return get_now().timestamp()

dt = get_now
ts = int(get_now_timestamp())
print(ts)
print(type(ts))