document.addEventListener("DOMContentLoaded", function () {
    const deleteButtons = document.querySelectorAll(".delete-button");

    deleteButtons.forEach(button => {
        button.addEventListener("click", function () {
            const bookId = this.getAttribute("data-id");

            if (confirm(`Are you sure you want to delete the book with ID ${bookId}?`)) {
                fetch(`/api/book/${bookId}`, { method: "DELETE" })
                    .then(response => {
                        if (response.ok) {
                            alert("Book deleted successfully!");
                            // Optionally, remove the row from the table
                            this.closest("tr").remove();
                        } else {
                            alert(`Failed to delete book. Server responded with ${response.status}`);
                        }
                    })
                    .catch(error => {
                        console.error("Error:", error);
                        alert("An error occurred while deleting the book.");
                    });
            }
        });
    });
});
