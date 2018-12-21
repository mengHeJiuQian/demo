import pexpect
child = pexpect.spawn('ssh root@47.100.117.86');
child.expect('`(yes/no)`');
child.sendline('1317598LY3201abc');
child.sendline('ls -lh');
try:
    res = child.expect_list(['root']);
    print(res)
except pexpect.TIMEOUT:
    raise
