| Farm |  | |
|---|---| --- |
| id | int | pk |
| name | string | |
| address | string | |

| Animal |  | |
|---|---| --- |
| id | int | pk |
| farm_id | int | fk | |
| code | string | |
| name | string | |
| birth_date | date | |
| breed_id | int | fk |
| sex | string | |
| weight | float | |
| status | string | |
* Unique: (code, farm_id)

| AnimalType |  | |
|---|---| --- |
| id | int | pk |
| name | string | |

| AnimalBreed |  | |
|---|---| --- |
| id | int | pk |
| name | string | |
| type_id | int | fk |

| Food |  | |
|---|---| --- |
| id | int | pk |
| name | string | |
| cost | float | |

| Nutrition |  | |
|---|---| --- |
| id | int | pk |
| food | string | |
| quantity | float | |
| unit | string | |
| frequency | int | |
| animal_type_id | int | fk |

| AnimalNutrition |  | |
|---|---| --- |
| id | int | pk |
| animal_id | int | fk |
| nutrition_id | int | fk |
| date | date | |
| quantity | float | |

| AnimalHealth |  | |
|---|---| --- |
| id | int | pk |
| animal_id | int | fk |
| date | date | |
| description | string | |
| treatment | string | |

| AnimalVaccine |  | |
|---|---| --- |
| id | int | pk |
| animal_id | int | fk |
| date | date | |
| vaccine | string | |

| AnimalPregnancy |  | |
|---|---| --- |
| id | int | pk |
| animal_id | int | fk |
| date | date | |
| status | string | |
| due_date | date | |

| AnimalMilk |  | |
|---|---| --- |
| id | int | pk |
| animal_id | int | fk |
| date | date | |
| quantity | float | |

| User |  | |
|---|---| --- |
| id | int | pk |
| username | string | |
| password | string | |
| role | string | |
| farm_id | int | fk |
