let finalXResult = 0;
let finalYResult = 0;
const historyList = document.getElementById('history');

function calculateVector() {
    // Getting values from the UI
    const mag = parseFloat(document.getElementById('vmag').value);
    const deg = parseFloat(document.getElementById('vang').value);
    const quad = parseInt(document.getElementById('vquad').value);

    if (isNaN(mag) || isNaN(deg) || isNaN(quad)) {
        alert("Please fill in all fields");
        return;
    }

    // Your logic: degrees to radians
    const radians = deg * (Math.PI / 180);

    // Your logic: finding X and Y components
    let xResult = mag * Math.cos(radians);
    let yResult = mag * Math.sin(radians);

    // Your logic: Quadrant adjustment
    if (quad === 2 || quad === 3) xResult *= -1;
    if (quad === 3 || quad === 4) yResult *= -1;

    // Update Totals
    finalXResult += xResult;
    finalYResult += yResult;

    // Display Current and Final
    const vectorStr = `${xResult.toFixed(2)}i + ${yResult.toFixed(2)}j`;
    document.getElementById('current').innerText = vectorStr;
    document.getElementById('final').innerText = `${finalXResult.toFixed(2)}i + ${finalYResult.toFixed(2)}j`;

    // Add to History (Replacing your ArrayList)
    const li = document.createElement('li');
    li.textContent = vectorStr;
    historyList.appendChild(li);
}