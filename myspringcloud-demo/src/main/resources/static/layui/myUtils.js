// 关闭当前iframe层
function closeCurrentIframe() {
    parent.layer.close(parent.layer.getFrameIndex(window.name));
}
// 关闭最新的弹出层
function closeLatest() {
    layer.close(layer.index);
}
function msgAndClose(msg) {
    layer.msg(msg, {time: 1500}, function () {
        closeCurrentIframe();
    });
}