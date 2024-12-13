const API_URL = "http://localhost:8080/javabank5/api/customer";

// Elementos do DOM
const form = document.getElementById("customerForm");
const addButton = document.getElementById("addButton");
const updateButton = document.getElementById("updateButton");
const resetButton = document.getElementById("resetButton");
let editingCustomerId = null;

// Carrega os clientes no início
document.addEventListener("DOMContentLoaded", () => {
    loadCustomers();
});

// Função para carregar os clientes
async function loadCustomers() {
    try {
        const response = await fetch(API_URL);
        if (!response.ok) {
            throw new Error(`Failed to fetch customers: ${response.statusText}`);
        }

        const customers = await response.json();
        populateTable(customers);
    } catch (error) {
        console.error("Error loading customers:", error);
    }
}


// Popula a tabela com os clientes
function populateTable(data) {
    const table = document.querySelector("tbody");
    table.innerHTML = ""; // Limpa a tabela antes de preencher

    data.forEach((customer) => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>${customer.email}</td>
            <td>${customer.phone}</td>
            <td>
                <button class="btn btn-success btn-sm" onclick="editCustomer(${customer.id})">Edit</button>
                <button class="btn btn-danger btn-sm" onclick="deleteCustomer(${customer.id})">Delete</button>
            </td>
        `;
        table.appendChild(row);
    });
}

// Adiciona um cliente
addButton.addEventListener("click", async () => {
    const customer = getFormData();

    try {
        const response = await fetch(API_URL, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(customer),
        });

        if (!response.ok) {
            throw new Error(`Failed to add customer: ${response.statusText}`);
        }

        const addedCustomer = await response.json();
        console.log("Customer added successfully:", addedCustomer);

        // Limpa o formulário
        form.reset();

        // Atualiza a tabela
        loadCustomers();
    } catch (error) {
        console.error("Error adding customer:", error);
    }
});


// Atualiza um cliente
updateButton.addEventListener("click", async () => {
    const customer = getFormData();

    try {
        await fetch(`${API_URL}/${editingCustomerId}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(customer),
        });
        form.reset();
        editingCustomerId = null;
        toggleButtons();
        loadCustomers();
    } catch (error) {
        console.error("Error updating customer:", error);
    }
});

// Deleta um cliente
async function deleteCustomer(id) {
    try {
        await fetch(`${API_URL}/${id}`, { method: "DELETE" });
        loadCustomers();
    } catch (error) {
        console.error("Error deleting customer:", error);
    }
}

// Edita um cliente
function editCustomer(id) {
    fetch(`${API_URL}/${id}`)
        .then((response) => response.json())
        .then((customer) => {
            setFormData(customer);
            editingCustomerId = id;
            toggleButtons();
        })
        .catch((error) => console.error("Error fetching customer:", error));
}

// Obter os dados do formulário
function getFormData() {
    return {
        firstName: document.getElementById("firstName").value,
        lastName: document.getElementById("lastName").value,
        email: document.getElementById("email").value,
        phone: document.getElementById("phone").value,
    };
}

// Preenche o formulário com os dados de um cliente
function setFormData(customer) {
    document.getElementById("firstName").value = customer.firstName;
    document.getElementById("lastName").value = customer.lastName;
    document.getElementById("email").value = customer.email;
    document.getElementById("phone").value = customer.phone;
}

// Alterna os botões entre adicionar e atualizar
function toggleButtons() {
    addButton.disabled = !!editingCustomerId;
    updateButton.disabled = !editingCustomerId;
    resetButton.disabled = !editingCustomerId;
}

// Reseta o formulário
resetButton.addEventListener("click", () => {
    form.reset();
    editingCustomerId = null;
    toggleButtons();
});
