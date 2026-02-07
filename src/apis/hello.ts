export async function hello() {
  return fetch("https://app.ipdatacloud.com/v1/ip_self_search", {
    method: "POST",
    headers: {
      "Referer": "https://www.ip66.net/"
    }
  })
    .then((res) => res.text())
}