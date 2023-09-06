# Catalogs REST API

Simple rest service for storing data in key pair values style.

## Headers

- **Authorization:** Bearer token (if required)

## Relationship

```
CATALOG:1 -> MANY:CATALOG_ITEMS
```

## Endpoints

### Create a Catalog

**Request**

- **Method:** POST
- **Endpoint:** `/api/catalogs`
- **Headers:** 
    - `Content-Type: application/json`

**Request Body**

```json
{
    "name": "Sample Catalog",
    "items": [
        {
            "data": "Item 1 Data"
        },
        {
            "data": "Item 2 Data"
        },
        {
            "data": "Item 3 Data"
        }
    ]
}
```

**Response**

```json
{
    "id": 1,
    "name": "Sample Catalog",
    "items": [
        {
            "id": 1,
            "data": "Item 1 Data"
        },
        {
            "id": 2,
            "data": "Item 2 Data"
        },
        {
            "id": 3,
            "data": "Item 3 Data"
        }
    ]
}
```

### Get All Catalogs

**Request**

- **Method:** GET
- **Endpoint:** `/api/catalogs`
- **Headers:** 
    - `Content-Type: application/json`

**Request Body**

```json
{}
```

**Response**

```json
[
    {
        "id": 1,
        "name": "Sample Catalog",
        "items": [
            {
                "id": 1,
                "data": "Item 1 Data"
            },
            {
                "id": 2,
                "data": "Item 2 Data"
            },
            {
                "id": 3,
                "data": "Item 3 Data"
            }
        ]
    }
]
```