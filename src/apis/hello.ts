export async function hello() {
  return fetch("https://www.baidu.com/")
    .then((res) => res.text())
}