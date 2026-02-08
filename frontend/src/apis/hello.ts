export async function hello(): Promise<string> {
  return fetch("/hello", {
    method: "GET",
  })
    .then((res) => res.text())
}