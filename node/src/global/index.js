console.log(__filename);
console.log(__dirname);

setTimeout(
    f, 2000
);
function f() {
    console.log(__filename);
}