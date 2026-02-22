document.addEventListener("DOMContentLoaded", async () => {
  const status = document.getElementById("status");

  try {
    // Get current active tab
    const [tab] = await chrome.tabs.query({
      active: true,
      currentWindow: true
    });

    const originalUrl = tab.url;

    // Call backend
    const response = await fetch("https://zipit-v2.onrender.com/api/urls/publicpathforshorturl", {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({ originalUrl })
    });

    const data = await response.json();

    // Copy to clipboard
    const newUrl= "https://zipit.netlify.app/s/"+data.shortUrl
    await navigator.clipboard.writeText(newUrl);

    status.innerText = "Copied to clipboard!";
  } catch (error) {
    console.error(error);
    status.innerText = "Error generating short URL";
  }
});